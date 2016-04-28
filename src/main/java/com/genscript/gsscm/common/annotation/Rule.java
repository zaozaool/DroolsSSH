package com.genscript.gsscm.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.genscript.gsscm.common.constant.Action;
import com.genscript.gsscm.common.constant.Site;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.FIELD })
public @interface Rule {

    // 属性适用的站点，如usorder
    public Site[] site() default {};

    // 属性不适用的站点，如usorder
    public Site[] ignoreSite() default {};

    // 属性适用的动作，如price计算，point计算
    public Action[] action() default {};

    // 属性不适用的动作，如price计算，point计算
    public Action[] ignoreAction() default {};

    // 属性适用的版本号
    public String[] version() default {};

    // 属性不适用的版本号
    public String[] ignoreVersion() default {};

    // 属性适用的规则名称
    public String[] ruleName() default {};

    // 属性不适用的规则名称
    public String[] ignoreRuleName() default {};

}
