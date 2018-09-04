(ns leiningen.migrate
  "Run drift migration scripts."
  (:require [drift.drift-version :as drift-version]
            [leiningen.core.eval :refer [eval-in-project]]))

(defn migrate [project & args]
  "Run migration scripts."
  (eval-in-project
    (update-in project [:dependencies]
      conj ['drift drift-version/version])
    `(drift.execute/run '~args)
    '(require 'drift.execute)))
