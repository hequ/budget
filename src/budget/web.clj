(ns budget.web
  (:require [compojure.core :refer [defroutes GET]]
            [ring.adapter.jetty :as ring]
            [ring.middleware.defaults :refer :all]))

(defroutes routes
  (GET "/" {{input :input} :params}
   (str "<h2>Hello world! " input "</h2>")))

(defn -main []
  (ring/run-jetty
    (wrap-defaults routes api-defaults)
    {:port 5000 :join? false}))

;; For interactive development:
(.stop server)
(def server (-main))
