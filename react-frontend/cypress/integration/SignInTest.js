describe('SignIn Test', () => {
    it('.get()', () => {
        cy.visit('http://localhost:3000/SignIn')
      cy.get('input[name="usrname"]')
      .type('admin1')
      .should('have.value', 'admin1')

      cy.get('input[name="password"]')
      .type('admin1')
      .should('have.value', 'admin1')

      
      cy.get('button[name="btn"]')
      .click()

      cy.url().should("include",'/')
    })
})
