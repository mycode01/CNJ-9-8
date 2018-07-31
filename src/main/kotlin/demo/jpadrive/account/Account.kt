package demo.jpadrive.account

import demo.jpadrive.address.Address
import demo.jpadrive.creditcard.CreditCard
import demo.jpadrive.data.BaseEntity
import javax.persistence.*

@Entity
class Account() : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id = 0L

    var accountNumber = ""

    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    var creditCards = mutableSetOf<CreditCard>()

    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    var addresses = mutableSetOf<Address>()

    constructor(accountNumber: String, addresses: Set<Address>) : this(accountNumber) {
        this.addresses.addAll(addresses)
    }

    constructor(accountNumber: String):this(){
        this.accountNumber = accountNumber
    }

}