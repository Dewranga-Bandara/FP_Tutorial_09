class Account(initialBalance: Double) {
  private var balance: Double = initialBalance

  def deposit(amount: Double): Unit = {
    require(amount > 0, "Amount must be positive")
    balance += amount
  }

  def withdraw(amount: Double): Unit = {
    require(amount > 0, "Amount must be positive")
    require(balance >= amount, "Insufficient balance")
    balance -= amount
  }

  def transfer(amount: Double, toAccount: Account): Unit = {
    require(amount > 0, "Amount must be positive")
    require(balance >= amount, "Insufficient balance")
    balance -= amount
    toAccount.balance += amount
  }

  def applyInterest(): Unit = {
    if (balance > 0) {
      balance += balance * 0.05
    } else if (balance < 0) {
      balance += balance * 0.1
    }
  }

  def getBalance: Double = balance
}

object Bank {
  def negativeBalances(accounts: List[Account]): List[Account] = {
    accounts.filter(_.getBalance < 0)
  }

  def totalBalance(accounts: List[Account]): Double = {
    accounts.map(_.getBalance).sum
  }

  def applyInterest(accounts: List[Account]): Unit = {
    accounts.foreach(_.applyInterest())
  }
}

object Q3 {
  def main(args: Array[String]): Unit = {
    val account1 = new Account(1000)
    val account2 = new Account(-500)
    val account3 = new Account(200)

    account1.deposit(200)
    account1.withdraw(100)
    account1.transfer(300, account2)

    val accounts = List(account1, account2, account3)

    println("Negative Balances:")
    Bank.negativeBalances(accounts).foreach(account => println(account.getBalance))

    println(s"Total Balance: ${Bank.totalBalance(accounts)}")

    println("Balances after applying interest:")
    Bank.applyInterest(accounts)
    accounts.foreach(account => println(account.getBalance))
  }
}
