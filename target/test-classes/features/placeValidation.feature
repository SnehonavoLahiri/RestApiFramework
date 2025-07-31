Feature: Perform and Validate Add/Delete/Get Place API working

  Scenario Outline: Perform AddPlace API to add places-->Perform DeletePlace API-->GetPlace of that Deleted-API
    Given User has Add place API with "<name>" "<phone>" "<address>" <latitude> <longitude> "<website>" "<language>"
    When User call "<addType>" with http "<addMethod>" request method
    Then "status" comes as "OK"
    When User call "<deleteType>" with http "<deleteMethod>" request method
    Then "status" comes as "OK"
    When User call "<getType>" with http "<getMethod>" request method
    

    Examples:
      | name       | phone       | address   | latitude   | longitude  | website             | language   | addType    | addMethod   | deleteType    | deleteMethod    | getType   | getMethod   |
      | Snehonavo  | 8583037615  | Serampore | -38.383494 | 33.427362  | http://google.com   | French-IN  | AddPlace   | POST        | DeletePlace   | DELETE					 | GetPlace  | GET				 |
      | Buban      | 8697437229  | Rishra    | -38.383492 | 33.427364  | http://youtube.com  | Russian-IN |	AddPlace   | POST        | DeletePlace   | DELETE					 | GetPlace  | GET				 |
      | Rohan      | 8697437329  | Mahesh    | -38.383492 | 33.427364  | http://youtube.com  | Spanish-IN | AddPlace   | POST        | DeletePlace   | DELETE					 | GetPlace  | GET         |
      | Tanmoy     | 8697437129  | Kolkata   | -38.323492 | 33.426364  | http://youtube.com  | Germany-IN | AddPlace   | POST        | DeletePlace   | DELETE					 | GetPlace  | GET         |

      