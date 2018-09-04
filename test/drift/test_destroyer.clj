(ns drift.test-destroyer
  (:require [clojure.test :refer :all]
            [drift.destroyer :refer :all]
            [test-helper :refer :all]))

(deftest test-migration-usage
  (migration-usage))
