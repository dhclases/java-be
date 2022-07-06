package com.bank.demo.domain;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;


@TestMethodOrder(MethodOrderer.MethodName.class)
@DisplayName("Attributes Account Test")
class AttributesAccountTest {
    private Account accountDefault;
    private final Integer LIMIT_DEFAULT = 100;
    private final String NAME_MERCHANT = "MERCHANT NAME";

    @DisplayName("Given an account")
    @BeforeEach
    void setUpBeforeEach() {

        accountDefault = new Account();
    }

    @DisplayName("Cleaning")
    @AfterEach
    void setUpAfterEach() {
        // Buen chico limpiar
    }

    @Test
    @DisplayName("The account is active")
    void isActive() {
        // Arrange
        // 1
        Account accountTest = new Account();
        // 2 Setup de objecto necesario
        // Act
        accountDefault.setActive(true);
        // accountTest.setActive(true);

        boolean isActive = accountDefault.isActive();

        // Assert
        Assertions.assertTrue(isActive);
    }

    @Test
    @DisplayName("Set account as active")
    void setActive() {
        // Arrange

        // Act
        accountDefault.setActive(false);
        // Assert
        Assertions.assertFalse(accountDefault.isActive());
    }

    @Test
    @DisplayName("Get available limit")
    void getAvailableLimit() {

        // Arrange

        // Act
        accountDefault.setAvailableLimit(LIMIT_DEFAULT);
        // Assert
        // Velor espera y valor resultado
        Assertions.assertEquals(LIMIT_DEFAULT, accountDefault.getAvailableLimit());

    }

    @Test
    @DisplayName("Set available limit")
    void setAvailableLimit() {
        // Arrange

        // Act
        accountDefault.setAvailableLimit(LIMIT_DEFAULT);

        // Assert
        Assertions.assertEquals(LIMIT_DEFAULT, accountDefault.getAvailableLimit());
    }
    @Nested
    @DisplayName("Given a history transaction")
    class HistoryTransactionTest {
        @Test
        @DisplayName("Then you can get history transaction")
        void getHistoryTransaction() {

            // Arrange
            List<Transaction> transactionList = new ArrayList<>();

            // Act
            accountDefault.setHistoryTransaction(transactionList);

            // Assert
            Assertions.assertEquals(0, accountDefault.getHistoryTransaction().size());
        }

        @Test
        @DisplayName("Then you can set a empty list of history transaction")
        void setHistoryTransaction() {

            // Arrange
            List<Transaction> transactionList = new ArrayList<>();

            // Act
            accountDefault.setHistoryTransaction(transactionList);

            // Assert
            Assertions.assertEquals(0, accountDefault.getHistoryTransaction().size());
        }

        @Test
        @DisplayName("Then you can add a item in the list of history transaction")
        void addHistoryTransactionTest() {

            // Arrange
            List<Transaction> transactionList = new ArrayList<>();

            Transaction transactionTest = new Transaction.Builder()
                    .mount(0.0)
                    .merchant(NAME_MERCHANT)
                    .build();

            // Act
            transactionList.add(transactionTest);
            accountDefault.setHistoryTransaction(transactionList);

            Transaction transactionExpected = accountDefault.getHistoryTransaction().get(0);

            // Assert
            Assertions.assertEquals(transactionExpected, transactionTest);
        }

    }
    /*
    @Nested
    @DisplayName("Given a new account")
    class AccountConstructorsTest {
        @Test
        @DisplayName("Then create account without attributes")
        void createAccountWithoutAttributes() {
            // Arrange
            Account account = new Account();
            // Act


            // Assert
            Assertions.assertNotNull(account);
        }

        @Test
        @DisplayName("Then create account is active")
        void createAccountActive() {
            // Arrange
            Account account = new Account(true);
            // Act

            // Assert
            Assertions.assertNotNull(account);
            Assertions.assertTrue(account.isActive());
        }

        @Test
        @DisplayName("Then create account with available Limit")
        void createAccountAvailableLimit() {
            // Arrange
            Account account = new Account(0);
            // Act


            // Assert
            Assertions.assertNotNull(account);
            Assertions.assertEquals(0, account.getAvailableLimit());
        }
        @Test
        @DisplayName("Then create account with history transaction empty")
        void createAccountHistoryTransaction() {
            // Arrange
            List<Transaction> history = new ArrayList<>();

            // Act
            Account account = new Account(history);

            // Assert
            Assertions.assertNotNull(account);
            Assertions.assertNotNull(account.getHistoryTransaction());
            Assertions.assertEquals(0,account.getHistoryTransaction().size());
        }


    }
*/
}