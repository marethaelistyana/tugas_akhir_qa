Feature: Filter product

  Scenario: User dapat memfilter produk
    Given user berada di halaman Product
    When user klik dropdown filter
    And user pilih filter
    Then menampilkan produk yang difilter
