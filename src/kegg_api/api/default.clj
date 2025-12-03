(ns kegg-api.api.default
  (:require [kegg-api.core :refer [call-api check-required-params with-collection-format *api-context*]]
            [clojure.spec.alpha :as s]
            [spec-tools.core :as st]
            [orchestra.core :refer [defn-spec]]
            [kegg-api.specs.-list-database-or-database-entries-get-database-or-database-entries-parameter :refer :all]
            [kegg-api.specs.kegg-database :refer :all]
            [kegg-api.specs.-info-database-get-database-parameter :refer :all]
            [kegg-api.specs.kegg-database-entries :refer :all]
            [kegg-api.specs.kegg-brite-option :refer :all]
            [kegg-api.specs.kegg-listable-database :refer :all]
            [kegg-api.specs.kegg-organism-code :refer :all]
            [kegg-api.specs.kegg-searchable-database :refer :all]
            )
  (:import (java.io File)))


(defn-spec find-database-query-get-with-http-info any?
  ""
  [database kegg-searchable-database, query string?]
  (check-required-params database query)
  (call-api "/find/{database}/{query}" :get
            {:path-params   {"database" database "query" query }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       []
             :auth-names    []}))

(defn-spec find-database-query-get any?
  ""
  [database kegg-searchable-database, query string?]
  (let [res (:data (find-database-query-get-with-http-info database query))]
    (if (:decode-models *api-context*)
       (st/decode any? res st/string-transformer)
       res)))


(defn-spec get-dbentries-options-get-with-http-info any?
  ""
  ([dbentries string?, ] (get-dbentries-options-get-with-http-info dbentries nil))
  ([dbentries string?, {:keys [options]} (s/map-of keyword? any?)]
   (check-required-params dbentries)
   (call-api "/get/{dbentries}/{options}" :get
             {:path-params   {"dbentries" dbentries "options" options }
              :header-params {}
              :query-params  {}
              :form-params   {}
              :content-types []
              :accepts       []
              :auth-names    []})))

(defn-spec get-dbentries-options-get any?
  ""
  ([dbentries string?, ] (get-dbentries-options-get dbentries nil))
  ([dbentries string?, optional-params any?]
   (let [res (:data (get-dbentries-options-get-with-http-info dbentries optional-params))]
     (if (:decode-models *api-context*)
        (st/decode any? res st/string-transformer)
        res))))


(defn-spec info-database-get-with-http-info any?
  "display database release information and linked db information
  This operation displays the database release information with statistics for the databases shown in Table 1. Except for kegg, genes and ligand, this operation also displays the list of linked databases that can be used in the link operation."
  [database -info-database-get-database-parameter]
  (check-required-params database)
  (call-api "/info/{database}" :get
            {:path-params   {"database" database }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["text/plain"]
             :auth-names    []}))

(defn-spec info-database-get string?
  "display database release information and linked db information
  This operation displays the database release information with statistics for the databases shown in Table 1. Except for kegg, genes and ligand, this operation also displays the list of linked databases that can be used in the link operation."
  [database -info-database-get-database-parameter]
  (let [res (:data (info-database-get-with-http-info database))]
    (if (:decode-models *api-context*)
       (st/decode string? res st/string-transformer)
       res)))


(defn-spec list-brite-br-organism-get-with-http-info any?
  "obtain a list of organism-specific brites"
  [organism string?]
  (check-required-params organism)
  (call-api "/list/brite/br/{organism}" :get
            {:path-params   {"organism" organism }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["text/plain"]
             :auth-names    []}))

(defn-spec list-brite-br-organism-get string?
  "obtain a list of organism-specific brites"
  [organism string?]
  (let [res (:data (list-brite-br-organism-get-with-http-info organism))]
    (if (:decode-models *api-context*)
       (st/decode string? res st/string-transformer)
       res)))


(defn-spec list-brite-ko-organism-get-with-http-info any?
  "obtain a list of organism-specific brites"
  [organism string?]
  (check-required-params organism)
  (call-api "/list/brite/ko/{organism}" :get
            {:path-params   {"organism" organism }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["text/plain"]
             :auth-names    []}))

(defn-spec list-brite-ko-organism-get string?
  "obtain a list of organism-specific brites"
  [organism string?]
  (let [res (:data (list-brite-ko-organism-get-with-http-info organism))]
    (if (:decode-models *api-context*)
       (st/decode string? res st/string-transformer)
       res)))


(defn-spec list-database-or-database-entries-get-with-http-info any?
  "obtain a list of entry identifiers and associated names
  This operation can be used to obtain a list of all entries in each database. The database names shown in Tables 1 and 2, excluding the composite database names of genes, ligand and kegg, may be given. The special database name \"organism\" is allowed only in this operation, which may be used to obtain a list of KEGG organisms with the three- or four-letter organism codes.

The second form may be used to obtain a list of definitions for a given set of database entry identifiers. The maximum number of identifiers that can be given is 10."
  [databaseOrDatabaseEntries -list-database-or-database-entries-get-database-or-database-entries-parameter]
  (check-required-params databaseOrDatabaseEntries)
  (call-api "/list/{databaseOrDatabaseEntries}" :get
            {:path-params   {"databaseOrDatabaseEntries" databaseOrDatabaseEntries }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["text/plain"]
             :auth-names    []}))

(defn-spec list-database-or-database-entries-get string?
  "obtain a list of entry identifiers and associated names
  This operation can be used to obtain a list of all entries in each database. The database names shown in Tables 1 and 2, excluding the composite database names of genes, ligand and kegg, may be given. The special database name \"organism\" is allowed only in this operation, which may be used to obtain a list of KEGG organisms with the three- or four-letter organism codes.

The second form may be used to obtain a list of definitions for a given set of database entry identifiers. The maximum number of identifiers that can be given is 10."
  [databaseOrDatabaseEntries -list-database-or-database-entries-get-database-or-database-entries-parameter]
  (let [res (:data (list-database-or-database-entries-get-with-http-info databaseOrDatabaseEntries))]
    (if (:decode-models *api-context*)
       (st/decode string? res st/string-transformer)
       res)))


(defn-spec list-pathway-organism-get-with-http-info any?
  "obtain a list of organism-specific pathways"
  [organism string?]
  (check-required-params organism)
  (call-api "/list/pathway/{organism}" :get
            {:path-params   {"organism" organism }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["text/plain"]
             :auth-names    []}))

(defn-spec list-pathway-organism-get string?
  "obtain a list of organism-specific pathways"
  [organism string?]
  (let [res (:data (list-pathway-organism-get-with-http-info organism))]
    (if (:decode-models *api-context*)
       (st/decode string? res st/string-transformer)
       res)))


