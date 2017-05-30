(ns budget.db.flyway
  (:require [environ.core :refer [env]]
            [budget.db.datasource :refer [jdbc-url]])
  (:import [org.flywaydb.core Flyway]))

(let [args (into-array '(""))
      flyway (new org.flywaydb.core.Flyway)]
  (.setDataSource flyway (jdbc-url) (env :db-user) (env :db-pass) args)
  (.migrate flyway))
