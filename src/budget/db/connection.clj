(ns budget.db.connection
  (:require [environ.core :refer [env]]
            [budget.db.datasource :refer [jdbc-url]])
  (:import com.mchange.v2.c3p0.ComboPooledDataSource))

(def db-spec
  {:user (env :db-user)
   :password (env :db-pass)
   :classname "org.postgresql.Driver"})

(defn pool [spec]
  (let [cpds (doto (ComboPooledDataSource.)
                (.setDriverClass (:classname spec))
                (.setJdbcUrl (jdbc-url))
                (.setUser (:user spec))
                (.setPassword (:password spec))
                (.setMaxIdleTimeExcessConnections (* 30 60))
                (.setMaxIdleTime (* 3 60 60)))]
      {:datasource cpds}))

(def pooled-db (delay (pool db-spec)))

(defn db-connection [] @pooled-db)
