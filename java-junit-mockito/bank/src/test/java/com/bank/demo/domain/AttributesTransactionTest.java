package com.bank.demo.domain;

import org.junit.jupiter.api.*;

@DisplayName("Given a transaction")
class AttributesTransactionTest {
    private Transaction transactionDefault;
    private final String MERCHANT_DEFAULT = "merchant-test";
    private final Double MOUNT_DEFAULT = 0.0;

    @BeforeEach
    void setUpBeforeEach() {
        transactionDefault = new Transaction();
    }

    @AfterEach
    void setUpAfterEach() {
        transactionDefault = null;
    }

    @Test
    @DisplayName("Get Merchant")
    void getMerchant() {
        // Arrange

        // Act
        transactionDefault.setMerchant(MERCHANT_DEFAULT);
        // Assert
        Assertions.assertEquals(MERCHANT_DEFAULT, transactionDefault.getMerchant());
    }

    @Test
    @DisplayName("Set Merchant")
    void setMerchant() {
        // Arrange

        // Act
        transactionDefault.setMerchant(MERCHANT_DEFAULT);
        // Assert
        Assertions.assertEquals(MERCHANT_DEFAULT, transactionDefault.getMerchant());
    }

    @Test
    @DisplayName("Get Mount")
    void getMount() {
        // Arrange

        // Act
        transactionDefault.setMount(MOUNT_DEFAULT);
        // Assert
        Assertions.assertEquals(MOUNT_DEFAULT, transactionDefault.getMount());
    }

    @Test
    @DisplayName("Set Mount")
    void setMount() {
        // Arrange

        // Act
        transactionDefault.setMount(MOUNT_DEFAULT);
        // Assert
        Assertions.assertEquals(MOUNT_DEFAULT, transactionDefault.getMount());

    }

    @Nested
    @DisplayName("Given a new transaction")
    class ConstructorTransactionTest {
        @Test
        @DisplayName("That you can create a new transaction without attributes")
        void createNewTransactionWithoutAttributes() {
            // Arrange
            Transaction transaction = new Transaction();
            // Act

            // Assert
            Assertions.assertNotNull(transaction);
        }

        @Test
        @DisplayName("That you can create a new transaction with merchant")
        void createNewTransactionWithMerchant() {
            // Arrange
            Transaction transaction = new Transaction(MERCHANT_DEFAULT);
            // Act

            // Assert
            Assertions.assertNotNull(transaction);
            Assertions.assertEquals(MERCHANT_DEFAULT, transaction.getMerchant());
        }

        @Test
        @DisplayName("That you can create a new transaction with mount")
        void createNewTransactionWithMount() {
            // Arrange
            Transaction transaction = new Transaction(MOUNT_DEFAULT);
            // Act

            // Assert
            Assertions.assertNotNull(transaction);
            Assertions.assertEquals(MOUNT_DEFAULT, transaction.getMount());
        }

        @Test
        @DisplayName("That you can create a new transaction with mount")
        void createNewTransactionWithMountAndMerchant() {
            // Arrange
            Transaction transaction = new Transaction(MERCHANT_DEFAULT, MOUNT_DEFAULT);
            // Act

            // Assert
            Assertions.assertNotNull(transaction);
            Assertions.assertEquals(MOUNT_DEFAULT, transaction.getMount());
            Assertions.assertEquals(MERCHANT_DEFAULT, transaction.getMerchant());
        }

        @Nested
        @DisplayName("Given a new transaction. You can use builder")
        class BuilderTransactionTest {
            @Test
            @DisplayName("That you can create a Transaction without attributes using builder")
            void createNewTransactionWithoutAttributes() {
                // Assets
                Transaction transactionTest = new Transaction.Builder().build();
                //Act

                // Assert
                Assertions.assertNotNull(transactionTest);
            }

            @Test
            @DisplayName("That you can create a Transaction with Merchant using builder")
            void createNewTransactionWithMerchant() {
                // Assets
                Transaction transactionTest = new Transaction.Builder()
                        .merchant(MERCHANT_DEFAULT)
                        .build();
                //Act

                // Assert
                Assertions.assertNotNull(transactionTest);
                Assertions.assertEquals(MERCHANT_DEFAULT,transactionTest.getMerchant());
            }

            @Test
            @DisplayName("That you can create a Transaction with mount using builder")
            void createNewTransactionWithMount() {
                // Assets
                Transaction transactionTest = new Transaction.Builder()
                        .mount(MOUNT_DEFAULT)
                        .build();
                //Act

                // Assert
                Assertions.assertNotNull(transactionTest);
                Assertions.assertEquals(MOUNT_DEFAULT,transactionTest.getMount());
            }

            @Test
            @DisplayName("That you can create a Transaction with mount and merchant using builder")
            void createNewTransactionWithMountAndMerchant() {
                // Assets
                Transaction transactionTest = new Transaction.Builder(MERCHANT_DEFAULT,MOUNT_DEFAULT).build();
                //Act

                // Assert
                Assertions.assertNotNull(transactionTest);
                Assertions.assertEquals(MOUNT_DEFAULT,transactionTest.getMount());
                Assertions.assertEquals(MERCHANT_DEFAULT,transactionTest.getMerchant());
            }

        }
    }
}