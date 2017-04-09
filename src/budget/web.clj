(ns budget.web
  (:require [compojure.core :refer [defroutes GET]]
            [ring.adapter.jetty :as ring]))

(defroutes routes
  (GET "/" [] "<h2>Hello world!</h2>"))

(defn -main []
  (ring/run-jetty #'routes {:port 5000 :join? false}))
