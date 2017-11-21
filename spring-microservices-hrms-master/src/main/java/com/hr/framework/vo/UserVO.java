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
public class UserVO implements Serializable {

  private static final long serialVersionUID = 6597728015488383528L;
  private Long id;
  private String name;
  private String usr;
  private String description;
}
