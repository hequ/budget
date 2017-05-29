(ns budget.db.flyway
  (:require [environ.core :refer [env]])
  (:import [org.flywaydb.core Flyway]))

(let [user (env db-user)
      pass (env :db-pass)
      args (into-array '(""))
      flyway (new org.flywaydb.core.Flyway)]
  (.setDataSource flyway "jdbc:postgresql://localhost:5432/budget" user pass args)
  (.migrate flyway))
