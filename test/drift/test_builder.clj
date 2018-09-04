(ns drift.test-builder
  (:require [drift.core :as core]
            [clojure.tools.logging :as logging]
            [clojure.test :refer :all]
            [drift.builder :refer :all]
            [test-helper :refer :all]))



(deftest test-find-or-create-migrate-directory
  (let [migrate-directory (find-or-create-migrate-directory (core/migrate-directory))]
    (test-directory migrate-directory "migrations"))
  (test-directory (find-or-create-migrate-directory) "migrations")
  (is (nil? (find-or-create-migrate-directory nil))))

(deftest test-create-migration-file
  (let [migrate-directory (find-or-create-migrate-directory)
        migration-file (create-migration-file migrate-directory "builder-test")]
    (test-file migration-file "003_builder_test.clj")
    (.delete migration-file))
  (let [migration-file (create-migration-file "builder-test")]
    (test-file migration-file "003_builder_test.clj")
    (.delete migration-file))
  (is (nil? (create-migration-file nil)))
  (is (nil? (create-migration-file (find-or-create-migrate-directory) nil)))
  (is (nil? (create-migration-file nil "create-test")))
  (is (nil? (create-migration-file nil nil))))
