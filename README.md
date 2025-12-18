<h1>Agent Curator</h1>
Agent Curator generates verified, structured academic curricula (5-Day Study Module) focused on complex fields like LLMs in Healthcare Ethics
<hr>

<img src="https://github.com/Jcc1112/Projects/blob/Agent-Curator/Chart.png?raw=true" alt="Homepage" height="400">

<h3>Project Overview - Agent Curator</h3>
NOTE: This agent is built using Kaggle. The Kaggle file will be uploaded below.<br><br>

This project contains the core logic for Agent Curator, a two-stage, sequential multi-agent system designed to generate highly structured and verifiable academic study modules. Built using the Google Gemini API, it separates real-time research (via the Google Search tool) from expert curriculum design to produce professional, factually grounded educational content from a simple topic prompt.

<h3>Problem Statement</h3>
The challenge was to efficiently generate highly specialized, verifiable, and structured academic content, specifically a 5-Day Study Module on the complex topic of "The ethical implications of using large language models in healthcare." Traditional single-agent LLM approaches often struggle with three key requirements:
Factual Grounding: Ensuring all facts, figures, and debates are current and verified via web search.
Specialization: Combining deep academic research with expert pedagogical design in a single output.
Strict Formatting: Adhering to a non-trivial output structure (e.g., Markdown table with defined fields like "Critical Prompt," "Estimated Time," and "Key Terms").

<h3>Solution Statement</h3>
The solution implemented a Sequential Multi-Agent System using the Google Gemini API. This architecture decomposes the complex task into two distinct, specialized roles:

A Lead Academic Strategist (Researcher), responsible for fact acquisition and synthesis via the Google Search tool.
A Learning Architect (Planner), responsible for pedagogical transformation and strict formatting of the raw research into a structured curriculum.
This hand-off model ensures the final output is both empirically grounded by the Researcher and meticulously formatted by the Planner, overcoming the limitations of single-agent pipelines.

<h3>Architecture</h3>
The project employs a two-step sequential workflow where the output of the first agent serves as the context (input) for the second agent.
System Flow

1. <b>Phase 1 (Research):</b> The Researcher agent autonomously uses the Google Search tool to gather up-to-date data.
2. <b>Phase 2 (Planning):</b> The entire research summary (over 10,000 characters) is passed as context to the Planner. The Planner, which has no external tools, focuses solely on applying its expert instructions to structure the content.
    Agent Roles

  <table style="width:100%">
  <tr>
    <th>Agent Core</th>
    <th> Function</th>
    <th>Key Differentiator</th>
    <th>Tool Use</th>
  </tr>
  <tr>
    <td>Researcher</td>
    <td>Fact acquisition, synthesis, and summarization.</td>
    <td>Enabled for real-time web search and factual grounding.y</td>
    <td>Google Search</td>
  </tr>
  <tr>
    <td>Planner</td>
    <td>Curriculum design, pedagogical structuring, and formatting.</td>
    <td>Disabled from searching; relies entirely on context for instruction.</td>
    <td>None</td>
  </tr>
</table>

<h3>Demo -- Show your solution</h3>
<b>Solution</b><br><br>
<h3>5-Day Study Module: Ethical Considerations of Large Language Models (LLMs) in Healthcare</h3><br><br>

<h6>Day 1: Core Ethical Pillars: Data, Bias, and Transparency</h6><br>

  - <b>Goal:</b> To define and understand the foundational ethical challenges of data privacy, algorithmic bias, and the critical need for transparency and explainability in LLMs within healthcare.
  - <b>Key Terms & Figures:</b> Patient Health Information (PHI), HIPAA, GDPR, Algorithmic Bias, Black-box nature, Explainable AI (XAI), Trust Deficit
  - <b>Estimated Time:</b> 60 minutes
  - <b>Critical Prompt:</b> The "trust deficit" in healthcare AI is rooted in concerns over data privacy, potential biases, and lack of transparency. How do these three elements interdependently erode trust among both clinicians and patients, and what is the primary consequence for LLM adoption?<br><br>
<h6>Day 2: Patient-Centric Principles: Autonomy, Accountability, and Safety</h6><br>

  - <b>Goal:</b> To analyze the ethical considerations surrounding patient autonomy, informed consent, accountability for LLM-informed decisions, and the critical imperatives for safety and reliability, including addressing various types of hallucinations.
  - <b>Key Terms & Figures:</b> Patient Autonomy, Informed Consent, Accountability, Hallucinations (factual errors, fabrications, misinterpretations), Over-reliance, Medical Errors
  - <b>Estimated Time:</b> 65 minutes
  - <b>Critical Prompt:</b> Considering that patient autonomy holds a pivotal position in medical ethics, how should the informed consent process be adapted to ensure patients are fully aware if LLMs influence their medical care, especially given the risks of misinformation and "medical hallucinations"?<br><br>
<h6>Day 3: Historical Evolution and Societal Equity in LLM Adoption</h6><br>

  - <b>Goal:</b> To trace the historical trajectory of LLM integration into healthcare, evaluate early and evolving ethical frameworks from the WHO, and examine the broader societal impact on equity, access, and the deepening digital divide.
  - <b>Key Terms & Figures:</b> ChatGPT, WHO guidance (2021, 2023, 2024), Generative AI, Digital Divide, Equity and Access, Large Multi-modal Models (LMMs)
  - <b>Estimated Time:</b> 55 minutes
  - <b>Critical Prompt:</b> The WHO's 2021 guidance emphasized that AI development must "not result in any mental or physical harm" and promoted "inclusiveness and equity." How do the high costs of LLM development and adoption directly threaten these core principles by potentially deepening the "digital divide" in public healthcare systems?<br><br>
<h6>Day 4: Navigating the Regulatory Landscape and Balancing Innovation</h6><br>

  - <b>Goal:</b> To explore the current global debates regarding regulatory frameworks for LLMs in healthcare, the complexities of balancing innovation with ethical integrity, and the challenges presented by specific application areas and "regulatory labyrinths."
  - <b>Key Terms & Figures:</b> Regulatory Frameworks, FDA, EU AI Act, Regulatory Labyrinths, Digital Health Software Precertification Program, Balancing Innovation and Ethical Integrity, Legal Uncertainty
  - <b>Estimated Time:</b> 60 minutes
  - <b>Critical Prompt:</b> The "regulatory labyrinths" designed for traditional medical devices struggle to address continuously evolving AI algorithms. What specific mechanisms or approaches could regulatory bodies adopt to keep pace with rapid LLM advancements while ensuring patient safety and ethical compliance?<br><br>
<h6>Day 5: Strategies for Mitigation, Human Oversight, and Future Threats</h6><br>

  - <b>Goal:</b> To investigate comprehensive mitigation strategies for bias and hallucinations, underscore the indispensable role of human oversight, and address the significant cybersecurity threats and the persistent trust deficit in healthcare AI.
  - <b>Key Terms & Figures:</b> Mitigation Strategies for Bias, Human Oversight, Retrieval-Augmented Generation (RAG), Prompt Engineering, Security Vulnerabilities, Cybersecurity threats (data poisoning, inference attacks), Trust Deficit
  - <b>Estimated Time:</b> 50 minutes
  - <b>Critical Prompt:</b> With simulated attacks showing high success rates (up to 81%) for accessing sensitive patient data via LLMs and over 60% of patients lacking trust in healthcare AI, what integrated strategy, combining technical safeguards (like RAG) and robust human oversight, is essential to build and maintain patient and clinician trust?<br><br>

<h3>Essential Tools and Utilities</h3><br>
The entire system is built upon the Google GenAI ecosystem, prioritizing integrated, native functionalities to maintain simplicity and performance.

<h3>Conclusion</h3><br>
The multi-agent system successfully executed the complex task, demonstrating full factual grounding and strict format adherence.<br><br>

 - <b>Researcher Execution:</b> Successfully conducted the deep-dive research, producing a summary of 10,429 characters (verified by the trace log).
 - <b>Planner Execution:</b> Successfully transformed the large context into the final curriculum structure, producing a 3,708-character Markdown output.
 - <b>Output Quality:</b> The resulting 5-Day Study Module is high-quality, professional, and incorporates all required elements, including specific objectives, key terms, estimated times, and complex critical thinking prompts for each day.

<h3>Value Statement</h3><br>
This project validates a highly effective, production-ready pattern for complex content generation. By integrating specialized agents with the Google Gemini LLM and its native Google Search tool, the system delivers:<br><br>

 - <b>High Quality & Accuracy:</b> Content is guaranteed to be up-to-date and grounded in web data.
 - <b>Scalable Customization:</b> New research topics or curriculum formats can be implemented simply by adjusting the role and instructions of the respective agents.
 - <b>Efficiency:</b> The separation of concerns maximizes the efficiency of the LLM by dedicating agents to their unique strengths (research vs. structuring).<br><br>

If there had been more time given, I would have turned this into a website for many others to use, which would eventually help them understand agent AI using the solution and code.

**NOTE: Gemini, Google search, and the 5-day AI agent course helped create this small project. Thank you team Kaggle, for this opportunity, as this was a great learning curve.**

      	 
  
			
			
