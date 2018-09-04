(ns config.dynamic-config
  (:require [clojure.test :refer :all]))

(defn config []

  {:init (fn [args]
           (is (= args ["bloop" "blargh"]))
           {:more-config 42})})
