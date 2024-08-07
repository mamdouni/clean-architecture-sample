# Core

Permitted annotations in this module are :
- Spring:
  - `@Component`
  - `@Service`
  - `@Configuration` + `@ConfigurationProperties` (must be in the same class)
- Lombok:
  - `@Data`
  - `@Builder`
  - `@NoArgsConstructor`
  - `@AllArgsConstructor`
  - ...
- MapStruct:
  - `@Mapper`
  - `@Mapping`
  - ...

DO NOT USE INFRASTRUCTURE ANNOTATIONS IN THIS MODULE !!!

Please Note for the `@Component` and `@Service` annotations, you can use a more standard annotation from the CDI specification like `@Named`.
Otherwise, you can just create the 'UseCases' with the '@Bean' annotation in the container module.