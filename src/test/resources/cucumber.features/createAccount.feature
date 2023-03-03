Feature: Smoke
  As a user
  I want to create a new account
  So that I can be logged in

  Scenario Outline: Verify the new account's creating with valid data
    Given User opens '<homePage>' page
    And User clicks on the My Account button in the Home page
    And User clicks on the Continue button
    And User checks the Male radio button
    And User types the first name '<userName>' in the First Name field and the last name '<userLastName>' in the Last Name field
    And User selects the date of birth '<birthDate>' in the Date of Birth's dropdown list
    And User types e-mail address in the E-Mail Address field with length equals '<emailLength>'
    And User types company name '<companyName>' in the Company Name field
    And User types street address '<streetAddress>' in the Street Address field and the post code '<postCode>' in the Post Code field
    And User types city '<userCity>' in the City field and the state '<userState>' in the State field
    And User selects the country '<userCountry>' from the Country dropdown list
    And User types the telephone number '<userTelephoneNumber>' in the Telephone Number field
    And User checks the Newsletter checkbox
    And User types the password '<userPassword>' in the Password field and in the Password Confirmation field
    When User submits entered valid information
    Then User checks the message '<successMessage>' about successful registration and the URL of Account Success Page '<accountSuccesPageUrl>'

    Examples:
      | homePage                                | userName             | userLastName        | birthDate  | emailLength | companyName       | streetAddress    | postCode | userCity  | userState  | userCountry | userTelephoneNumber | userPassword | successMessage                | accountSuccesPageUrl       |
      | http://practice.bpbonline.com/index.php | Test User First Name | Test User Last Name | 07/30/1988 |8            | Test User Company | Test User street | 12300    | User City | User state | Ukraine     | 380661234590        | 123456789    | Your Account Has Been Created | create_account_success.php |


  Scenario Outline: Verify the new account's creating with invalid data
    Given User opens '<homePage>' page
    And User clicks on the My Account button in the Home page
    And User clicks on the Continue button
    And User checks the Male radio button
    And User types the first name '<userName>' in the First Name field and the last name '<userLastName>' in the Last Name field
    And User selects the date of birth '<birthDate>' in the Date of Birth's dropdown list
    And User types e-mail address in the E-Mail Address field with length equals '<emailLength>'
    And User types company name '<companyName>' in the Company Name field
    And User types street address '<streetAddress>' in the Street Address field and the post code '<postCode>' in the Post Code field
    And User types city '<userCity>' in the City field and the state '<userState>' in the State field
    And User selects the country '<userCountry>' from the Country dropdown list
    And User types the telephone number '<userTelephoneNumber>' in the Telephone Number field
    And User checks the Newsletter checkbox
    And User types the password '<userPassword>' in the Password field and in the Password Confirmation field
    When User submits entered invalid information
    Then User checks the message '<errorMessage>' about error registration

    Examples:
      | homePage                                | userName             | userLastName        | birthDate  | emailLength | companyName       | streetAddress    | postCode | userCity  | userState  | userCountry | userTelephoneNumber | userPassword | errorMessage                                               |
      | http://practice.bpbonline.com/index.php | !                    | Test User Last Name | 07/30/1988 |8            | Test User Company | Test User street | 12300    | User City | User state | Ukraine     | 380661234590        | 123456789    | Your First Name must contain a minimum of 2 characters     |
      | http://practice.bpbonline.com/index.php | Test User First Name |                     | 07/30/1988 |8            | Test User Company | Test User street | 12300    | User City | User state | Ukraine     | 380661234590        | 123456789    | Your Last Name must contain a minimum of 2 characters      |
      | http://practice.bpbonline.com/index.php | Test User First Name | Test User Last Name | 07/30/1988 |8            | Test User Company |                  | 12300    | User City | User state | Ukraine     | 380661234590        | 123456789    | Your Street Address must contain a minimum of 5 characters |
      | http://practice.bpbonline.com/index.php | Test User First Name | Test User Last Name | 07/30/1988 |8            | Test User Company | Test User street | !        | User City | User state | Ukraine     | 380661234590        | 123456789    | Your Post Code must contain a minimum of 4 characters      |
      | http://practice.bpbonline.com/index.php | Test User First Name | Test User Last Name | 07/30/1988 |8            | Test User Company | Test User street | 12300    |           | User state | Ukraine     | 380661234590        | 123456789    | Your City must contain a minimum of 3 characters           |
