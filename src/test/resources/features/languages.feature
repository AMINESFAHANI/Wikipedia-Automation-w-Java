Feature: Multiple Languages should be supported

  Scenario: Navigate to English Wikipedia
    Given The Guest is on the Wikipedia Home Page
    When The Guest clicks on English
    Then The Guest should be on the English Home Page

  Scenario: Navigate to Spanish Wikipedia
    Given The Guest is on the Wikipedia Home Page
    When The Guest clicks on Spanish
    Then The Guest should be on the Spanish Home Page

  Scenario: Navigate to Italian Wikipedia
    Given The Guest is on the Wikipedia Home Page
    When The Guest clicks on Italian
    Then The Guest should be on the Italian Home Page

  Scenario: Person Loves to quickly navigate between pages
    Given The Guest is on the Wikipedia Home Page
    When The Guest clicks on Italian
    Given The Guest is on the Wikipedia Home Page
    When The Guest clicks on Spanish
    Given The Guest is on the Wikipedia Home Page
    When The Guest clicks on English
    Given The Guest is on the Wikipedia Home Page
    When The Guest clicks on Spanish

  Scenario Outline: Multiple Search Languages should be supported
    Given The Guest is on the Wikipedia Home Page
    When The Guest clicks the drop down search Language button and select a "<language>" from drop down list
    When The Guest clicks the searchInputButton button
    Then The Guest should be on the specific language Search Page with "<title>"

    Examples:
    |language | title |
    | Simple English  |Search - Simple English Wikipedia, the free encyclopedia |
    | فارسی | جستجو - ویکی‌پدیا، دانشنامهٔ آزاد |
     | العربية | بحث - ويكيبيديا |
    | اردو| تلاش - آزاد دائرۃ المعارف، ویکیپیڈیا |


 Scenario: Search All Languages should be supported
    Given The Guest is on the Wikipedia Home Page and search in all languages

 Scenario: Reading in Multiple Language Should Be supported
    Given The Guest is on the Wikipedia Home Page
    Then The Guest Is Able To Read In Multiple Languages



  Scenario Outline: Reading wikipedia in your own language
    Given The Guest is on the Wikipedia Home Page
    When The Guest clicks the ReadInYourLanguage Button button
    When The Guest Select A Specific "<language>"
    Then The Guest should be on the specific language Search Page with "<title>"
    Given The Guest is on the Wikipedia Home Page

    Examples:
      | language | title |
      | English | Wikipedia, the free encyclopedia |
      | فارسی | ویکی‌پدیا، دانشنامهٔ آزاد |
      | العربية  | ويكيبيديا، الموسوعة الحرة |
      | اردو     | ویکیپیڈیا، آزاد دائرۃ المعارف |

