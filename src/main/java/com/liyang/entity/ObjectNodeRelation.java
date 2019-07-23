package com.liyang.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;

/**
 * @Author: Pan
 * @Date: 2019/7/22 10:29
 * @Description:
 **/
@Getter
@Setter
@NoArgsConstructor
public class ObjectNodeRelation {
    @Id
    @GeneratedValue
    private Long id;

}
