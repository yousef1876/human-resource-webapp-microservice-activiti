package com.hr.framework.filter;

import com.hr.framework.config.bean.RequestBean;
import com.hr.framework.constant.CommonsConstant;
import com.hr.framework.servlet.RequestWrapper;
import com.hr.framework.tools.LogUtils;
import com.hr.framework.tools.RemoteAddressUtils;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * Limit filter.
 * <pre>
 *   I use map as an cache in this case.
 *   You can also use redis.
 * </pre>
 *
 * @author <a href="http://github.com/saintdan">Liao Yifan</a>
 * @date 20/10/2017
 * @since JDK1.8
 */
@Component
@Order(2)
@WebFilter(filterName = "LimitFilter")
public class LimitFilter implements Filter {

  @Override public void init(FilterConfig filterConfig) throws ServletException {
    LogUtils.trackInfo(logger, "Initiating LimitFilter");
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    if (request instanceof HttpServletRequest) {
      RequestWrapper req = new RequestWrapper((HttpServletRequest) request);
      final String LIMIT_KEY = "Limit-Key";
      String limitKey = req.getHeader(LIMIT_KEY);
      if (StringUtils.isNotBlank(limitKey)) {
        ((HttpServletResponse) response).setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
        return;
      }
      chain.doFilter(req, response);
    } else {
      ((HttpServletResponse) response).setStatus(HttpStatus.BAD_REQUEST.value());
    }
  }

  @Override public void destroy() {
    LogUtils.trackInfo(logger, "Destroying LimitFilter");
  }

  private static final Logger logger = LoggerFactory.getLogger(LimitFilter.class);
  private final RequestBean requestBean;

  @Autowired public LimitFilter(RequestBean requestBean) {
    this.requestBean = requestBean;
  }

  private boolean limit(RequestLimit requestLimit) {
    String key = String
        .join(CommonsConstant.UNDERLINE, requestLimit.getIp(), requestLimit.getPath(),
            requestLimit.getLimitKey());
    if (!map.containsKey(key)) {
      map.put(key, new RequestCount(key, 1, System.currentTimeMillis()));
    } else {
      RequestCount requestCount = map.get(key);
      long frequency = (System.currentTimeMillis() - requestCount.getFirstReqAt());
      if (frequency > requestLimit.getRange()) {
        map.remove(key);
      } else {
        if (requestCount.getCount() >= requestLimit.getCount() && frequency <= requestLimit
            .getRange()) {
          return false;
        } else {
          requestCount.setCount(requestCount.getCount() + 1);
          map.remove(key);
          map.put(key, requestCount);
        }
      }
    }
    return true;
  }

  private HashMap<String, RequestCount> map = new HashMap<>();

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  private class RequestLimit {

    private String ip; // Request ip
    private String path; // Request resource's path
    private String limitKey; // Key of limit
    private long range; // Millisecond
    private int count; // Request count
    
    /*public RequestLimit(String x, String y, String z, long range, int count){
    	
    	this.ip =  x;
    	this.path = y;
    	this.limitKey = z;
    	this.range = range;
    	this.count = count;
    	
    	
    }*/
    
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getLimitKey() {
		return limitKey;
	}
	public void setLimitKey(String limitKey) {
		this.limitKey = limitKey;
	}
	public long getRange() {
		return range;
	}
	public void setRange(long range) {
		this.range = range;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
    
    
    
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  private class RequestCount {

    private String key;
    private int count;
    private Long firstReqAt;
    
    public RequestCount(String key, int count, long firstReqAt){
    	this.key = key;
    	this.count = count;
    	this.firstReqAt = firstReqAt;
    }
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Long getFirstReqAt() {
		return firstReqAt;
	}
	public void setFirstReqAt(Long firstReqAt) {
		this.firstReqAt = firstReqAt;
	}
    
    
    
  }
}
