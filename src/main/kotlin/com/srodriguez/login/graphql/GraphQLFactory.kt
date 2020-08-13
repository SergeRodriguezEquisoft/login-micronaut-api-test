package com.srodriguez.login.graphql

import com.expediagroup.graphql.SchemaGeneratorConfig
import com.expediagroup.graphql.TopLevelObject
import com.expediagroup.graphql.toSchema
import com.srodriguez.login.graphql.schema.UsersQuery
import graphql.GraphQL
import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Factory
import io.micronaut.core.io.ResourceResolver
import javax.inject.Singleton

@Factory
class GraphQLFactory {

    @Bean
    @Singleton
    fun graphQL(resourceResolver: ResourceResolver): GraphQL {

        val config = SchemaGeneratorConfig(supportedPackages = listOf("com.srodriguez.login.graphql.schema"))
        val queries = listOf(TopLevelObject(UsersQuery()))

//        val parser = SchemaParser()
//        val generator = SchemaGenerator()
//
//        val typeRegistry = TypeDefinitionRegistry()
//        typeRegistry.merge(parser.parse(resourceResolver.getResourceAsReader("classpath:schema.graphqls")))
//
//        val runtimeWiring =  RuntimeWiring.newRuntimeWiring()
//                .type("Query") {typeWiring -> typeWiring.dataFetcher("users", UsersFetcher())}
//                .build()
//
//        val schema = generator.makeExecutableSchema(typeRegistry, runtimeWiring)
        return GraphQL.newGraphQL(toSchema(config, queries, emptyList())).build()
    }
}

//class UsersFetcher: DataFetcher<List<Users>> {
//    override fun get(environment: DataFetchingEnvironment?): List<Users> {
//        return listOf(
//                Users("1", "SRodriguez", "SRodriguez", "serge.rodriguez@equisoft.com"),
//                Users("2", "JNicloux", "JNicloux", "jeremie.nicloux@equisoft.com"))
//    }
//
//}