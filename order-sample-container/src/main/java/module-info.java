module org.example.architecture.order.container {

    requires lombok;
    requires jakarta.annotation;
    requires org.aspectj.weaver;
    requires spring.context;
    requires spring.data.jpa;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires org.slf4j;
    requires spring.data.commons;
    requires org.example.architecture.order.infra;
    requires org.example.architecture.order.business;
}