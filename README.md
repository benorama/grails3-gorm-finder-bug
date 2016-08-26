# Demo app for Grails3 GORM finder issue

The app src has 2 interfaces `Account` and `Item`.

```groovy
package test.app

interface Account {

  String getName()
  void setName(String name)

}
```

```groovy
package test.app

interface Item {

  Account getAccount()
  void setAccount(Account account)

}
```

Two domain classes implements those interfaces.

```groovy
package test.app

class FacebookAccount implements Account {

    String name

}
```

```groovy
package test.app

class FacebookItem implements Item {

    static belongsTo = [account: FacebookAccount]

    void setAccount(Account account) {
      this.account = account as FacebookAccount
    }
}
```


1. Run the app

```
grails run-app
```

2. Open console http://localhost:8080/console

3. Execute the following code

```groovy
import test.app.*

FacebookItem.findAllByAccount(FacebookAccount.get(1))
```

You'll get the following exception `org.hibernate.QueryException: could not resolve property: account of: test.app.FacebookItem`.

The same app and code is running fine on Grails 2.4.4.

# Update to solve the issue

Thanks to Graeme, here is the solution: by adding the setter  `setAccount` the property becomes read-only.

To solve the issue, the corresponding setters must be added:

```groovy
package test.app

class FacebookItem implements Item {

    static belongsTo = [account: FacebookAccount]

    FacebookAccount getAccount() {
      this.account
    }
    void setAccount(FacebookAccount account) {
      this.account = account
    }
    void setAccount(Account account) {
      this.account = account as FacebookAccount
    }
}
```
