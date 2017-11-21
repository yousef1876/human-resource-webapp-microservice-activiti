package com.hr.framework.vo;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResourceVO implements Serializable {

  private static final long serialVersionUID = 8917291426920312742L;
  private Long id;
  private String name;
  private String description;
}
