(ns kegg-api.specs.-info-database-get-database-parameter
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def -info-database-get-database-parameter-data
  {
   })

(def -info-database-get-database-parameter-spec
  (ds/spec
    {:name ::-info-database-get-database-parameter
     :spec -info-database-get-database-parameter-data}))
