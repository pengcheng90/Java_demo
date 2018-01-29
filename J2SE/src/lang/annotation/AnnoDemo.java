package lang.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 自定义注解（使用@interface标识为注解）
 */
@Retention(value = RetentionPolicy.RUNTIME )  /*@Retention注解上的注解，表示注解在运行时保留*/
public @interface AnnoDemo {

    String value();         /*注意加（）*/
}
