package demo.jpadrive.customer

import demo.jpadrive.account.Account
import demo.jpadrive.data.BaseEntity
import javax.persistence.*

@Entity
class Customer() : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id = 0L

    var firstName = ""
    var lastName = ""
    var email = ""
    @OneToOne(cascade = [CascadeType.ALL])
    var account: Account? = null

    constructor(firstName: String, lastName: String, email: String, account: Account) : this() {
        this.firstName = firstName
        this.lastName = lastName
        this.email = email
        this.account = account
    }

}