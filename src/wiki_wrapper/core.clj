(ns wiki-wrapper.core
  (:gen-class)
  (require [clj-http.client :as client]))

(defrecord MediaWiki [url options])

(def sample-query-map
  (hash-map :format "json"
    :action "query"
    :titles "Main Page"
    :prop "revisions"
    :rvprop "content"))

(def endpoint "http://en.wikipedia.org/w/api.php?")

(defn get-request
  [url]
  (let [page (client/get url)]
    (println page)))
;(println "works"))

(defn make-api-request
  "form-data is a map"
  [form-data]
  (client/get (str endpoint (get-arg-string form-data))))

(defn get-arg-string
  "form-data is a map. Returns a string of <key>=<value> with & interposed in between.
  To be used for the URL."
  [form-data]
  (apply str (interpose "&" 
  	(map (fn[x] (client/generate-query-string {(name (nth x 0)) (nth x 1)})) (seq form-data)))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (client/get "http://en.wikipedia.org/w/api.php" sample-query-map)
  ;(get-request "http://en.wikipedia.org/w/api.php?format=xml&action=query&titles=Main+Page&prop=revisions&rvprop=content"))
