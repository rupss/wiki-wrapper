(ns wiki-wrapper.core
  (:gen-class)
  (require '[clj-http.client :as client]))

(defn get-request
  [url]
  (let [page (client/get "http://google.com")]
    (println (page :headers))))
;(println "works"))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
