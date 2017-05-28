(ns budget.web
  (:require [compojure.core :refer [defroutes GET]]
            [ring.adapter.jetty :as ring]
            [ring.middleware.defaults :refer :all]
            [ring.middleware.json :refer :all]))


(defroutes routes
  (GET "/" {{input :input} :params}
   (str "<h2>Hello world! " input "</h2>")))

(defn -main []
  (-> routes
      (wrap-json-params {:keywords? true})
      (wrap-defaults api-defaults)
      (ring/run-jetty {:port 5000 :join? false})))

;; For interactive development:
(.stop server)

(def server (-main))
