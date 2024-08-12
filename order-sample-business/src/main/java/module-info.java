module org.example.architecture.order.business {

    exports org.example.architecture.order.business.application.product.ports.inputs;
    exports org.example.architecture.order.business.domain.product.ports.outputs;
    exports org.example.architecture.order.business.domain.product.domain;
    exports org.example.architecture.order.business.domain.product.exceptions;
    requires lombok;
    requires spring.context;
    requires org.apache.commons.lang3;
    requires spring.boot;
    requires org.slf4j;
}