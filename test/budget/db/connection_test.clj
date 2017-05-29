(ns budget.db.connection-test
  (:require [clojure.test :refer :all]
            [budget.db.connection :refer [db-connection]]
            [clojure.java.jdbc :as jdbc]))

(defn do-query []
  (jdbc/query (db-connection) ["SELECT * FROM purchase"]))

(deftest read-from-db
  (testing "SELECT * from purchase should return empty list"
    (is (= (do-query) ()))))
