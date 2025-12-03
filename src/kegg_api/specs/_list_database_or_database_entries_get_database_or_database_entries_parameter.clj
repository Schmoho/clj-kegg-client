(ns kegg-api.specs.-list-database-or-database-entries-get-database-or-database-entries-parameter
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def -list-database-or-database-entries-get-database-or-database-entries-parameter-data
  {
   })

(def -list-database-or-database-entries-get-database-or-database-entries-parameter-spec
  (ds/spec
    {:name ::-list-database-or-database-entries-get-database-or-database-entries-parameter
     :spec -list-database-or-database-entries-get-database-or-database-entries-parameter-data}))
