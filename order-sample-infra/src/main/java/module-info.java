module org.example.architecture.order.infra {

    requires lombok;
    requires spring.context;
    requires spring.core;
    requires spring.web;
    requires spring.webmvc;
    requires spring.tx;
    requires spring.beans;
    requires spring.data.jpa;
    requires spring.data.commons;
    requires spring.boot;
    requires org.mapstruct;
    requires jakarta.persistence;
    requires org.slf4j;
    requires org.example.architecture.order.business;
}