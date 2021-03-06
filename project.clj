(defproject budget "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/java.jdbc "0.6.1"]
                 [org.postgresql/postgresql "42.1.1"]
                 [ring/ring-jetty-adapter "1.5.1"]
                 [ring/ring-defaults "0.2.3"]
                 [ring/ring-json "0.4.0"]
                 [compojure "1.5.2"]
                 [org.flywaydb/flyway-core "4.2.0"]
                 [proto-repl "0.3.1"]
                 [com.mchange/c3p0 "0.9.5.2"]
                 [environ "1.1.0"]]
  :plugins [[lein-environ "1.1.0"]])
