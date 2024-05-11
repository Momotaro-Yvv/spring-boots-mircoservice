Feature: As an Github Api consumer, I want to retrieve repository with highest stars

  Scenario: Get top 1 repos with with highest stars from the last week
    Given url microserviceUrl+'/starredRepo?n=1'
    When method get
    Then status 200
    And match response ==
    """
    [
      {
      html_url: '#string',
      watchers_count: '#number',
      language: '#string',
      description: '#string',
      name: '#string'
      }
    ]
    """

  Scenario: Get top 10 repos with with highest stars from the last week
    Given url microserviceUrl+'/starredRepo?n=10'
    When method get
    Then status 200
    And match response == '#[10]'

  Scenario: Get top -1 repos with with highest stars from the last week
    Given url microserviceUrl+'/starredRepo?n=-1'
    When method get
    Then status 400