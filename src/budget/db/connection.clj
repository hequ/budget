(ns budget.db.connection
  (:require [environ.core :refer [env]])
  (:import com.mchange.v2.c3p0.ComboPooledDataSource))

(def db-spec
  {:subprotocol "postgresql"
   :dbtype "postgresql"
   :dbname "budget"
   :host "localhost"
   :port 5432
   :user (env :db-user)
   :password (env :db-pass)})

(defn pool [spec]
  (let [cpds (doto (ComboPooledDataSource.)
                (.setDriverClass (:classname spec))
                (.setJdbcUrl (str "jdbc:postgresql://"
                              (:host spec)
                              ":"
                              (:port spec)
                              "/"
                              (:dbname spec)))
                (.setUser (:user spec))
                (.setPassword (:password spec))
                (.setMaxIdleTimeExcessConnections (* 30 60))
                (.setMaxIdleTime (* 3 60 60)))]
      {:datasource cpds}))

(def pooled-db (delay (pool db-spec)))

(defn db-connection [] @pooled-db)
