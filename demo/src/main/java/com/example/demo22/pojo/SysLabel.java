package com.example.demo22.pojo;

import java.io.Serializable;
/**
 * 标签实体类
 * @author chenbilang
 */
public class SysLabel implements Serializable {

        private Long id;
        private String name;
        private Integer weight;

        public Long getId() {
            return id;
        }
        public void setId(Long id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public Integer getWeight() {
            return weight;
        }
        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "SysLabel{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", weight=" + weight +
                    '}';
        }

}
