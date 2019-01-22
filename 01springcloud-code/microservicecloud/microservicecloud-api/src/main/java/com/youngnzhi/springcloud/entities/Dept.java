package com.youngnzhi.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: youngnzhi
 * Date: 2018/12/10
 * Time: 23:14
 * Description：lombokc查看使用
 * @AllArgsConstructor 生成全参构造函数
 * @NoArgsConstructor 生成空参构造函数
 * @Data 生成类中属性的get和set方法
 * @Accessors(chain=true) 支持链式表达 new Dept().setDeptno(1L).setDname("kevin");
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain=true)
public class Dept implements Serializable {

    private static final long serialVersionUID = -981839141122225725L;

    //主键
    private Long deptno;

    //部门名称
    private String dname;

    //来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库
    private String db_source;

    public Long getDeptno() {
        return deptno;
    }

    public void setDeptno(Long deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDb_source() {
        return db_source;
    }

    public void setDb_source(String db_source) {
        this.db_source = db_source;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Dept{" +
                "deptno=" + deptno +
                ", dname='" + dname + '\'' +
                ", db_source='" + db_source + '\'' +
                '}';
    }
}