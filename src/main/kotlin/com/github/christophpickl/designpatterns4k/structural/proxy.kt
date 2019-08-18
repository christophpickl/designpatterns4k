package com.github.christophpickl.designpatterns4k.structural


interface Account {
    val balance: Int
    fun withdrawMoney(amount: Int)
}

class CurrentAccount(private var internalBalance: Int) : Account {
    override val balance get() = internalBalance
    override fun withdrawMoney(amount: Int) {
        println("Withdrawing $amount money.")
        internalBalance -= amount
    }
}

// the proxy
class NotBelowZeroAccount(private val delegate: Account) : Account {
    override val balance: Int get() = delegate.balance

    override fun withdrawMoney(amount: Int) {
        if (balance - amount < 0) {
            throw Exception("Not enough money!")
        }
        delegate.withdrawMoney(amount)
    }
}

object ProxyApp {
    @JvmStatic
    fun main(args: Array<String>) {
        val account = NotBelowZeroAccount(CurrentAccount(400))
        account.withdrawMoney(350)
        account.withdrawMoney(100)
    }
}
