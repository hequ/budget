(ns budget.db)

(:import [org.flywaydb.core Flyway])

(let [user ""
      pass ""
      args (into-array '(""))
      flyway (new org.flywaydb.core.Flyway)]
  (.setDataSource flyway "jdbc:postgresql://localhost:5432/budget" user pass args)
  (.migrate flyway))
