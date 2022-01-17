describe('Register Test', () => {
    it('.get()', () => {
        cy.visit('http://localhost:3000/SignUp')
      cy.get('input[name="usrname"]')
      .type('nevena')

      cy.get('input[name="email"]')
      .type('nevena@gmail.com')


      cy.get('input[name="password"]')
      .type('nevena')

      
      cy.get('button[name="btn"]')
      .click()

      cy.url().should("include",'/SignIn')
    })
})
