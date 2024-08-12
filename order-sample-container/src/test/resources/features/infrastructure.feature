Feature: The infrastructure configuration
  In this feature we will check if the health endpoints of our application are well exposed or not

  Scenario: the health endpoint will reply
    When we call "/actuator/health"
    Then it receives a status OK_200 and:
      """
      status: UP
      groups:
        - liveness
        - readiness
      """

  Scenario Template: the health probes will reply UP
    When we call "<endpoint>"
    Then it receives a status OK_200 and:
      """
      status: UP
      """
    Examples:
      | endpoint                   |
      | /actuator/health/liveness  |
      | /actuator/health/readiness |