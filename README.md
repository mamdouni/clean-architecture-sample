# Clean Architecture Sample

This is a sample project to demonstrate the Clean Architecture approach in Java development.

## How to use the app

Get products :
http://localhost:8080/api/v1/products

Create a product :

```shell
curl -X POST http://localhost:8080/api/v1/products \
-H "Content-Type: application/json" \
--data '{
  "name": "Mouse",
  "description": "a simple mouse",
  "type": "FINISHED_GOOD",
  "price": 100.0,
  "priceCurrency": "USD"
}'
```

here's a global overview of the project architecture :
![clean-architecture-global.png](images%2Fclean-architecture-global.png)

and a more detailed view of the architecture and the role of each layer:
![clean-architecture.drawio.png](images%2Fclean-architecture.drawio.png)


## References
- https://www.youtube.com/watch?v=mbNzUkNjrnA
- https://www.youtube.com/watch?v=LTxJFQ6xmzM
- https://github.com/spember/spring-shoestore
- https://blog.octo.com/architecture-hexagonale-clean-architecture-bonnet-blanc-blanc-bonnet-compte-rendu-du-talk-de-christophe-breheret-girardin-du-comptoir-x-la-duck-conf-2023
- https://www.udemy.com/course/microservices-clean-architecture-ddd-saga-outbox-kafka-kubernetes/?couponCode=KEEPLEARNING
- https://github.com/agelenler/food-ordering-system
- https://github.com/agelenler/food-ordering-system-infra
- https://blog.octo.com/architecture-hexagonale-trois-principes-et-un-exemple-dimplementation
