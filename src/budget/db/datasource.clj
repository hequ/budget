(ns budget.db.datasource
  (:require [environ.core :refer [env]]))

(defn jdbc-url []
  (str "jdbc:" (env :db-type) "://" (env :host) ":" (env :port)
    "/" (env :db-name)))
