/* This test is intended to run after ghost_post_install_test.js */

describe('Ghost Tests - 2', function () {
/*
    //Check if environment it's ok
    it('.should() - confirm ghost is online', function () {
      cy.visit('http://localhost:2368')
      cy.title().should('include', 'Test Blog')

    })

    //Login admin account
    it('.should() - login admin account', function(){
        cy.visit('http://localhost:2368/ghost')
        cy.get('#ember448').type('my@email.com')
        cy.get('#ember450').type('pwd12345678')
        cy.get('#ember460 > span').click()
        cy.title().should('include', 'Content')
    })

    //Logout admin account
    it('.should() - logout admin account', function(){
        cy.visit('http://localhost:2368/ghost')
        cy.get('#ember448').type('my@email.com')
        cy.get('#ember450').type('pwd12345678')
        cy.get('#ember460 > span').click()
        cy.get('.gh-nav-menu').click()
        cy.get('.user-menu-signout').click()
        cy.title().should('include', 'Sign In')
    })
*/
    
    //Post an entry in a blog
    it('.should() - logout admin account', function(){
        cy.visit('http://localhost:2368/ghost')
        cy.get('#ember448').type('my@email.com')
        cy.get('#ember450').type('pwd12345678')
        cy.get('#ember460 > span').click()
        cy.title().should('include', 'Content')
        cy.get('.gh-nav-main-editor').contains('New story').click()
        cy.get('.gh-editor-title').type('Test post Title')
    })

})
 

