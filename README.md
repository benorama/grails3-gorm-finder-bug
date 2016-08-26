# Demo app for Grails3 GORM issue

1. Run the app

```
grails run-app
```

2. Open console http://localhost:8080/console

3. Execute the following code

```
import test.app.*

FacebookItem.findAllByAccount(FacebookAccount.get(1))
```

You'll get the following exception `org.hibernate.QueryException: could not resolve property: account of: test.app.FacebookItem`.

The same app and code is running fine on Grails 2.4.4.
