@Kupondas
Feature: Kupondas Feature

  Scenario: Kupondas Tum Paylasimlar kupon oynama kontrol
    When I click BasePage login button
    And I set LoginPage : username "16272930"  and password "256292Vs."
    And Click : Login Page : Giris Yap button
    And Click : Home Page : Kupondas button
    And Click : Kupondas Page : Tum Paylasimlar Filter Button
    And Click : Kupondas Page : Tum Paylasimlar : First Hemen Oyna Button
    Then Get : Coupon Detail : Coupon Info
    And Click : Coupon Detail : Hemen Oyna Button
    Then Verify : Basket : Coupon Info Control
