### 여러 spec 사용하기

https://springfox.github.io/springfox/docs/snapshot/#aggregating-multiple-swagger-specifications-in-the-same-swagger-ui

### cors 처리

```java
@Bean
public CorsFilter corsFilter() {
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

    // Allow anyone and anything access. Probably ok for Swagger spec
    CorsConfiguration config = new CorsConfiguration();
    config.setAllowCredentials(true);
    config.addAllowedOrigin("*");
    config.addAllowedHeader("*");
    config.addAllowedMethod("*");

    source.registerCorsConfiguration("/v2/api-docs", config);
    return new CorsFilter(source);
}
```
