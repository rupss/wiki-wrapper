(ns wiki-wrapper.core
  (:gen-class)
  (require [clj-http.client :as client]))

(defrecord MediaWiki [url options])

(defn get-request
  [url]
  (let [page (client/get url)]
    (println page)))
;(println "works"))

(defn make-api-request
  "form-data is a map"
  [url form-data]
  )

(defn get-arg-string
  "form-data is a map"
  [form-data]
  (apply str (interpose "&" 
  	(map (fn[x] (client/generate-query-string {(name (nth x 0)) (nth x 1)})) (seq form-data)))))

(def sample-query-map
  (hash-map :format "json"
    :action "query"
    :titles "Main Page"
    :prop "revisions"
    :rvprop "content"))

(def db
  (hash-map :format "json"
    :action "query"
    :titles "Main Page"
    :prop "revisions"
    :rvprop "content"))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (client/get "http://en.wikipedia.org/w/api.php" sample-query-map)
  ;(get-request "http://en.wikipedia.org/w/api.php?format=xml&action=query&titles=Main+Page&prop=revisions&rvprop=content"))
